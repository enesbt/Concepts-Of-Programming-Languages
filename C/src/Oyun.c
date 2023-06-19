#include "Oyun.h"


Oyun OyunOlustur(int populasyonsay)
{
    Oyun this;
    this = (Oyun)malloc(sizeof(struct OYUN));
    this->turanTaktik = TuranTaktikOLustur();
    this->bosKaleTaktik = BosKaleTaktikOlustur();
    this->auretim=AUretimOlustur();
    this->buretim=BUretimOlustur();
    this->EslesmeSonu= &EslesmeSonu;
    this->KoloniUret = &KoloniUret;
    this->populasyonSay = populasyonsay;
    this->yoket = &OyunYokEt;
    this->koloniler = (Koloni*)malloc(populasyonsay * sizeof(Koloni));   
    this->Oyna = &Oyna;
    this->Tur = &Tur;
    this->YasayanSayisi = &YasayanSayisi;   
}
enum TaktikRandom
{
    turan =0,
    bosKale=1
};
enum UretimRandom
{
    auretim=0,
    buretim=1
};


void KoloniUret(const Oyun this,int* populasyonlar) // koloniler olusturulur.
{

    int i;
    for(i=0;i<this->populasyonSay;i++)
    {
        int taktikSecim = rand() % 2; 
        enum TaktikRandom taktik2 = taktikSecim;
        Taktik a;
        int taktik;
        int uretim;
        if(taktik2==turan)
        {
            a = this->turanTaktik->super;
            taktik = 0;
        }        
           
        else if(taktik2==bosKale)
        {
            a = this->bosKaleTaktik->super;
            taktik =1;
        }
            
        int uretimSecim = rand() % 2; 
        enum UretimRandom uretim2 = uretimSecim;
        Uretim b;
        if(uretim2==auretim)
        {
            b =  this->auretim->super;
            uretim = 0;
        }
            
        else if(uretim2==buretim)
        {
            b =  this->buretim->super;
            uretim = 1;
        }
            

        char randomChar;
        do {
            int randomNum = rand() % 5000+1;
            randomChar = randomNum;
        } while (randomChar == ' ' || randomChar == '\0');
        Koloni koloni = KoloniOlustur(populasyonlar[i],randomChar,a,b,taktik,uretim);
        this->koloniler[i] = koloni;   
    }
   
}

int YasayanSayisi(const Oyun this) //yasayan koloni sayisi kontrol
{
       
    int yasayan = 0;

    for(int i=0;i<this->populasyonSay;i++)
    {
        if(this->koloniler[i]->YasiyorMu(this->koloniler[i]))
            yasayan++;
    }
    return yasayan;
 
}


void Tur(const Oyun this) //tur dondurme
{
    int tur = 0;

    while(YasayanSayisi(this)!=1&&YasayanSayisi(this)!=0)
    {
        
        if(YasayanSayisi(this)==0)
            Yazdir(this,tur);
        Oyna(this);
        for(int i =0;i < this->populasyonSay;i++)
        {
            
            if(YasiyorMu(this->koloniler[i]))
            {
                
                if(this->koloniler[i]->uretim==0)
                    this->koloniler[i]->yemekStogu += this->koloniler[i]->uretimTeknigi->Uret(this->auretim,this->koloniler[i]->populasyon);  
                    
                else
                    this->koloniler[i]->yemekStogu += this->koloniler[i]->uretimTeknigi->Uret(this->buretim,this->koloniler[i]->populasyon);                
                this->koloniler[i]->populasyon +=  (this->koloniler[i]->populasyon *20)/100;
                this->koloniler[i]->yemekStogu -=  this->koloniler[i]->populasyon *2;
            }
        }
        tur++;
        system("cls");
        Yazdir(this,tur);              
    }
}

void Oyna(const Oyun this)  //her turdaki yapilan savas
{
    int i,j;
    int fark;
    int yuzde;
    int kol1,kol2;
    for(i=0;i<this->populasyonSay-1;i++) //koloni dizisindeki her koloninn birbiriyle savasmasi 
    {
        if(YasiyorMu(this->koloniler[i]))
        {
           for(j=i+1;j<this->populasyonSay;j++)
            {
                if(this->koloniler[i]->taktik==0)
                    kol1 = this->koloniler[i]->savasTaktigi->Savas(this->turanTaktik,this->koloniler[i]->populasyon);
                else
                    kol1 = this->koloniler[i]->savasTaktigi->Savas(this->bosKaleTaktik,this->koloniler[i]->populasyon);
            
            
                if(YasiyorMu(this->koloniler[j]))
                {
                    if(this->koloniler[i]->taktik==0)
                        kol2 = this->koloniler[j]->savasTaktigi->Savas(this->turanTaktik,this->koloniler[j]->populasyon);
                    
                    else
                        kol2 = this->koloniler[j]->savasTaktigi->Savas(this->bosKaleTaktik,this->koloniler[j]->populasyon);
                                      
                    fark = abs(kol1-kol2);
                    yuzde  = fark / 10 ;
                
                    if(kol1>kol2)
                    {              
                        this->EslesmeSonu(this,i,j,yuzde);                                        
                    }
                    else if(kol2>kol1)
                    {
                        this->EslesmeSonu(this,j,i,yuzde);
                    }
                    else
                    {
                        if(this->koloniler[i]->populasyon>this->koloniler[j]->populasyon)
                            this->EslesmeSonu(this,i,j,yuzde);
                        else if(this->koloniler[i]->populasyon<this->koloniler[j]->populasyon)
                            this->EslesmeSonu(this,j,i,yuzde);
                        else
                            this->EslesmeSonu(this,i,j,yuzde);
                    }
                }
                
            }
        }        
        
    }
}
void EslesmeSonu(const Oyun this,int kazanan ,int kaybeden,int yuzde) //savas sonu
{  
    int azalt =  (this->koloniler[kaybeden]->populasyon *yuzde)/100;
    
    if(azalt>0)
    {
        int yemeks = 0;
        this->koloniler[kaybeden]->populasyon -=  azalt;
        yemeks = (this->koloniler[kaybeden]->yemekStogu *yuzde)/100;
        this->koloniler[kaybeden]->yemekStogu -= yemeks;
        this->koloniler[kaybeden]->kaybetmeSayisi++;
        this->koloniler[kazanan]->kazanmaSayisi++;
        this->koloniler[kazanan]->yemekStogu +=yemeks;              
    }
    else
    {
        this->koloniler[kaybeden]->populasyon -=1;
        this->koloniler[kaybeden]->yemekStogu -= 10;
        this->koloniler[kaybeden]->kaybetmeSayisi++;
        this->koloniler[kazanan]->kazanmaSayisi++;
        this->koloniler[kazanan]->yemekStogu +=10;            
    }
}



void Yazdir(const Oyun this,int tur)
{
    printf("------------------------------------------------\n");
    printf("Tur Sayisi:%d\n",tur);
    printf("%-10s%-15s%-15s%-10s%-10s\n", "Koloni", "Populasyon", "YemekStogu", "Kazanma", "Kaybetme");
    for(int i=0;i<this->populasyonSay;i++)
    {
         
       
        if(YasiyorMu(this->koloniler[i]))
        {
            printf("%-10c%-15d%-15d%-10d%-10d\n",
            this->koloniler[i]->sembol,
            this->koloniler[i]->populasyon,
            this->koloniler[i]->yemekStogu,
            this->koloniler[i]->kazanmaSayisi,
            this->koloniler[i]->kaybetmeSayisi);
        }
        else
        {            
            printf("%-10c%-15s%-15s%-10s%-10s\n",
                this->koloniler[i]->sembol,
                "--",
                "--",
                "--",
                "--"
        );
        }
     
    }
    printf("------------------------------------------------\n");
}

void OyunYokEt(const Oyun this)
{
    if(this==NULL) return;
    this->turanTaktik->yoket(this->turanTaktik);
    this->bosKaleTaktik->yoket(this->bosKaleTaktik);
    this->auretim->yoket(this->auretim);
    this->buretim->yoket(this->buretim);
    for(int i = 0;i<this->populasyonSay;i++)
    {
        this->koloniler[i]->yoket(this->koloniler[i]);
    }
    free(this);
}
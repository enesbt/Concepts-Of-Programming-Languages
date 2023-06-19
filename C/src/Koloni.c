#include "Koloni.h"


Koloni KoloniOlustur(int populasyon,char sembol,Taktik savasTaktik,Uretim uretimTeknigi,int taktik,int uretim)
{
    
    Koloni this;
    this = (Koloni)malloc(sizeof(struct KOLONI));
    this->populasyon = populasyon;
    this->savasTaktigi = savasTaktik;
    this->uretimTeknigi = uretimTeknigi;
    this->yemekStogu = populasyon*populasyon;
    this->kaybetmeSayisi = 0;
    this->kazanmaSayisi  = 0;
    this->sembol = sembol;
    this->YasiyorMu = &YasiyorMu;
    this->yoket = &KoloniYoket;
    this->taktik = taktik;
    this->uretim = uretim;

}
boolean YasiyorMu(const Koloni this)
{
    if(this->populasyon<=0 || this->yemekStogu<=0)
        return false;
    return true;
}

void KoloniYoket(const Koloni this)
{
    if(this==NULL) return;
    free(this);
}
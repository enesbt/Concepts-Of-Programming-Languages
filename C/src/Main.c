#include "Taktik.h"  
#include "TuranTaktik.h"
#include "BosKaleTaktik.h"
#include "Uretim.h"
#include "AUretim.h"
#include "Koloni.h"
#include "Oyun.h"
#include <string.h>
#include <time.h>


int main()
{
   
    srand(time(NULL));
    char ifade[1500];
    printf("Bir ifade girin: ");
    fgets(ifade, 1500, stdin);

    int *sayilar = NULL;
    int sayi;
    int i = 0;
    char *parca = strtok(ifade, " \n");
    while (parca != NULL) {
        sayi = atoi(parca);
        i++;
        sayilar = realloc(sayilar, i * sizeof(int));
        if (sayilar == NULL) {
            printf("Bellek yetersiz!\n");
            exit(1);
        }
        sayilar[i-1] = sayi;
        parca = strtok(NULL, " \n");
    }

   
    int sayac = 0;
    for (int j = 0; j < i; j++) 
    {
        sayac++;
    }
    
    printf("\n");
    Oyun oyun = OyunOlustur(sayac);
    oyun->KoloniUret(oyun,sayilar);
    oyun->Tur(oyun);
    oyun->yoket(oyun);
    free(sayilar);
 

    return 0;
}
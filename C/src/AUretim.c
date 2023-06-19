#include "AUretim.h"

AUretim AUretimOlustur()
{
    AUretim this;
    this = (AUretim)malloc(sizeof(struct AURETIM));
    this->super = UretimOlustur();
    this->super->Uret = &Uret;
    this->yoket = &AUretimYoket;  
    return this;
}


int Uret(const AUretim this,int populasyon) 
{
    if(populasyon>500)
        return 10;
    else if(populasyon<=500&&populasyon>250)
        return rand() % 6 + 5;
    else if(populasyon<=250)
        return rand()%6;
    else
        return 0;
}

void AUretimYoket(const AUretim  this)
{
    if(this==NULL) return;
    this->super->yoket(this->super);
    free(this);
}
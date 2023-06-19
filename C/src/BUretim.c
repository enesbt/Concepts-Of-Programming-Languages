#include "BUretim.h"

BUretim BUretimOlustur()
{
    BUretim this;
    this = (BUretim)malloc(sizeof(struct BURETIM));
    this->super = UretimOlustur();
    this->super->Uret = &uret;
    this->yoket = &BUretimYoket;
    return this;
}


int uret(const BUretim this,int populasyon)
{
    if(populasyon<100)
        return 10;
    else if(populasyon>=100&&populasyon<250)
        return  rand() % 5 + 5;
    else if(populasyon>=500)
        return rand()%4;
    else
        return rand()%5;
}

void BUretimYoket(const BUretim  this)
{
    if(this==NULL) return;
    this->super->yoket(this->super);
    free(this);
}
#include "BosKaleTaktik.h"

BosKaleTaktik BosKaleTaktikOlustur()
{
    BosKaleTaktik this;
    this = (BosKaleTaktik)malloc(sizeof(struct BOSKALETAKTIK));
    this->super = TaktikOlustur();
    this->super->Savas = &savas;
    this->yoket = &BosKaleTaktikYoket; 
    return this;
}


int savas(const BosKaleTaktik this,int populasyon)
{
    if(populasyon>10&&populasyon<100)
        return rand() % 101 + 900;
    else if(populasyon>100&&populasyon<500)
        return rand() % 101+250;
    else if(populasyon>500)
        return rand()% 101+400;
    else if(populasyon<=10)
        return rand()% 501 + 500;
    else
        return rand()%101;
}

void BosKaleTaktikYoket(const BosKaleTaktik  this)
{
    if(this==NULL) return;
    this->super->yoket(this->super);
    free(this);
}
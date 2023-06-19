#include "TuranTaktik.h"


TuranTaktik TuranTaktikOLustur()
{
    TuranTaktik this;
    this= (TuranTaktik)malloc(sizeof(struct TURANTAKTIK));
    this->super = TaktikOlustur();
    this->super->Savas= &Savas;
    this->yoket = &TuranTaktikYoket;

    return this;
}

int Savas(const TuranTaktik this,int popsay)
{
    if(popsay>400)
        return rand() % 201 + 800;
    else if(popsay<400&& popsay>100)
        return rand() % 201 + 600;
    else if(popsay<100&& popsay>50)
        return rand() % 401 + 200;
    else if(popsay<=50&&popsay>10)
        return rand() % 101+100;
    else if(popsay<=10)
        return  rand()%101;      
}
void TuranTaktikYoket(const TuranTaktik this)
{
    if(this==NULL) return;
    this->super->yoket(this->super);

    free(this);
}
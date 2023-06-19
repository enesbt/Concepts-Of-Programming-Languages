#include "Taktik.h"



Taktik TaktikOlustur()
{
    Taktik this;
    this = (Taktik)malloc(sizeof(struct TAKTIK));
    this->yoket = &TaktikYokEt;
    return this;
}


void TaktikYokEt(const Taktik this)
{
   if(this==NULL) return;
    free(this);
    
}
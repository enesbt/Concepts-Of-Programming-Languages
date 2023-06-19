#ifndef BURETIM_H
#define BURETIM_H

#include "Uretim.h"

struct BURETIM
{
    Uretim super;
    void(*yoket)(struct BURETIM*);
};

typedef struct BURETIM* BUretim;

BUretim BUretimOlustur();
int uret(const BUretim,int);
void BUretimYoket(const BUretim);


#endif
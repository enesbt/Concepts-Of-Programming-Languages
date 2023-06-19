#ifndef AURETIM_H
#define AURETIM_H

#include "Uretim.h"

struct AURETIM
{
    Uretim super;
    void(*yoket)(struct AURETIM*);
};

typedef struct AURETIM* AUretim;

AUretim AUretimOlustur();
int Uret(const AUretim,int);
void AUretimYoket(const AUretim);


#endif

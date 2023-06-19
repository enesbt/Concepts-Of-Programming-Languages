#ifndef URETIM_H
#define URETIM_H

#include "stdlib.h"
#include "stdio.h"
#include <time.h>


struct URETIM
{
    
    int (*Uret)();
    void(*yoket)(struct URETIM*);
};

typedef struct URETIM* Uretim;

Uretim UretimOlustur();
void UretimYokEt(const Uretim);

#endif
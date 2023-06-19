#ifndef TAKTIK_H
#define TAKTIK_H

#include "stdlib.h"
#include "stdio.h"
#include <time.h>


struct TAKTIK
{
    int (*Savas)();
    void(*yoket)(struct TAKTIK*);

};
typedef struct TAKTIK* Taktik;
Taktik TaktikOlustur();
void TaktikYokEt(const Taktik);
#endif
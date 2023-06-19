#ifndef TURANTAKTIK_H
#define TURANTAKTIK_H

#include "Taktik.h"
struct TURANTAKTIK
{
    Taktik super;
    int popsay;
    void(*yoket)(struct TURANTAKTIK*);
};

typedef struct TURANTAKTIK* TuranTaktik;

TuranTaktik TuranTaktikOLustur();
int Savas(const TuranTaktik,int);
void TuranTaktikYoket(const TuranTaktik);


#endif
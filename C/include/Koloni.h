#ifndef KOLONI_H
#define KOLONI_H
#include "Taktik.h"
#include "Uretim.h"
#include "stdlib.h"
#include "stdio.h"


typedef enum Bool{false,true} boolean;

struct KOLONI
{
    int populasyon;
    Taktik savasTaktigi;
    Uretim uretimTeknigi;
    int yemekStogu;
    int kazanmaSayisi;
    int kaybetmeSayisi;
    char sembol;
    int taktik; //0 turan  1 boskale
    int uretim;
    boolean (*YasiyorMu)(struct KOLONI*);
    void(*yoket)(struct KOLONI*);
};

typedef struct KOLONI* Koloni;

Koloni KoloniOlustur(int ,char  ,Taktik ,Uretim ,int,int);
boolean YasiyorMu(const Koloni);
void KoloniYoket(const Koloni);

#endif
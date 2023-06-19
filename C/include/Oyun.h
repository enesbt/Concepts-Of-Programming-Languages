#ifndef OYUN_H
#define OYUN_H

#include "stdlib.h"
#include "stdio.h"
#include "Koloni.h"
#include "TuranTaktik.h"
#include "BosKaleTaktik.h"
#include "AUretim.h"
#include "BUretim.h"
#include <time.h>

struct OYUN
{
    void(*yoket)(struct OYUN*);
    void(*KoloniUret)(struct OYUN*,int*);
    void(*deneme)(struct OYUN*);
    void(*Oyna)(struct OYUN*);
    void(*EslesmeSonu)(struct OYUN*,int,int,int);
    void(*Tur)(struct OYUN*);
    void(*Yazdir)(struct OYUN*,int);
    int(*YasayanSayisi)(struct OYUN*);
   TuranTaktik turanTaktik;
   BosKaleTaktik bosKaleTaktik;
   AUretim auretim;
   BUretim buretim;
   int populasyonSay;
   Koloni *koloniler;

};
typedef struct OYUN* Oyun;

Oyun OyunOlustur(int);
void KoloniUret(const Oyun,int*);
void OyunYokEt(const Oyun);
void EslesmeSonu(const Oyun,int ,int,int);
void Tur(const Oyun);
void Yazdir(const Oyun,int);
int YasayanSayisi(const Oyun);
void Oyna();

#endif
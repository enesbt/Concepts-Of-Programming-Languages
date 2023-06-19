#ifndef BOSKALETAKTIK_H
#define BOSKALETAKTIK_H

#include "Taktik.h"

struct BOSKALETAKTIK
{
    Taktik super;
    void(*yoket)(struct BOSKALETAKTIK*);
};

typedef struct BOSKALETAKTIK* BosKaleTaktik;

BosKaleTaktik BosKaleTaktikOlustur();
int savas(const BosKaleTaktik,int);
void BosKaleTaktikYoket(const BosKaleTaktik);


#endif
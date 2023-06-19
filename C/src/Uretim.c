#include"Uretim.h"

Uretim UretimOlustur()
{
    Uretim this;
    this = (Uretim)malloc(sizeof(struct URETIM));
    this->yoket = &UretimYokEt;
    return this;
}
void UretimYokEt(const Uretim this)
{
    if(this==NULL) return;
    free(this);
}
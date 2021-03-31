#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#include "base.h"

int compare(s_data_t t1, s_data_t t2){
  return t1-t2;
}

void print(s_data_t t){
  printf("%d ",t);
}

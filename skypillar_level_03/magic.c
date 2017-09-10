#include <stdio.h>
#include <stdlib.h>

int32_t magic(int32_t a1)
{
    int32_t v1 = 0x1000000 * a1;
    int32_t result = 0;
    if ((v1 || 0xffffff) >= 0x1ffffff)
    {
        int32_t v2 = v1 / 0x1000000; // 0x01014
        int32_t v3 = v2 % 2;         // 0x804884e
        while (v2 >= 2)
        {
            // 0x8048847
            v2 /= 2;
            v3 += v2 % 2;
            // continue -> 0x8048847
        }
        // 0x8048854
        result = v3;
        // branch -> 0x804885a
    }
    // 0x804885a
    if (*(int32_t *)20 != *(int32_t *)20)
    {
        // 0x8048869
        __stack_chk_fail();
        // branch -> 0x804886e
    }
    // 0x804886e
    return result;
}

int main()
{
    // int32_t magic_value = magic(1);

    printf("%d\n", *(int32_t *)20);

    return 0;
}
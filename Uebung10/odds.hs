odds :: [Int]
odds = 1 : (map (\x -> x + 2) odds)

from :: Int -> [Int]
from x = x : from (x + 1)

drop_mult :: Int -> [Int] -> [Int]
drop_mult x xs = filter (\y -> mod y x /= 0) xs

dropall :: [Int] -> [Int]
dropall (x : xs) = x : dropall (drop_mult x xs)

primes :: [Int]
primes = dropall (from 2)


skalarprodukt :: [Int] -> [Int] -> [Int]
skalarprodukt (va : lista) (vb : listb) = va * vb : (skalarprodukt lista listb)

gutePrimes :: [Int]
gutePrimes = dropZero(f (drop 1 primes) prodlist)
                            where   prodlist = skalarprodukt primes (drop 2 primes)
                                    dropZero = filter (\x -> x /= 0)
                                    f = zipWith (\x y -> if (x*x) > y then x else 0)

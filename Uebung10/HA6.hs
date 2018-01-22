data List a = Nil | Cons a (List a) deriving Show

list :: List Int
list = Cons (-3) (Cons 14 (Cons (-6) (Cons 7 (Cons 1 Nil))))

blist :: List Int
blist = Cons 1 (Cons 1 (Cons 0 (Cons 0 Nil)))

filterList :: (a -> Bool) -> List a -> List a
filterList f Nil        = Nil
filterList f (Cons v l) = if f v then Cons v (filterList f l) else (filterList f l)

divisibleBy :: Int -> List Int -> List Int
divisibleBy num         = filterList (\v -> v `mod` num == 0)

foldList :: (a -> b -> b) -> b -> List a -> b
foldList f c Nil            = c
foldList f c (Cons v l)     = f v (foldList f c l)

listMaximum :: List Int -> Int
listMaximum Nil         = 0
listMaximum list        = foldList (\x y -> if x > y then x else y) 0 list

zipLists :: (a -> b -> c) -> List a -> List b -> List c
zipLists f Nil Nil                   = Nil
zipLists f Nil _                     = Nil
zipLists f _ Nil                     = Nil
zipLists f (Cons va la) (Cons vb lb) = Cons (f va vb) (zipLists f la lb)

skalarprodukt :: List Int -> List Int -> Int
skalarprodukt Nil Nil       = 0
skalarprodukt Nil _         = 0
skalarprodukt _ Nil         = 0
skalarprodukt lista listb   = foldList sum 0 resList
                                where   sum = \x y -> x + y
                                        resList = zipLists (\x y -> x * y) lista listb

data Tree = Nil | Node Int Tree Tree deriving Show

testTree = Node 2 (Node 4 (Node 9 Nil Nil) (Node 3 Nil (Node 7 Nil Nil))) (Node 17 Nil Nil)

foldTree :: (Int -> a -> a -> a) -> a -> Tree -> a
foldTree f c Nil = c
foldTree f c (Node v l r) = f v (foldTree f c l) (foldTree f c r)

prodTree = foldTree (\v l r -> v * l * r) 1

prodTree_ :: Tree -> Int
prodTree_ Nil = 1
prodTree_ (Node v l r) = (\v l r -> v * l * r) v (prodTree l) (prodTree r)

incTree = foldTree (\v l r -> (Node (v + 1) l r)) Nil

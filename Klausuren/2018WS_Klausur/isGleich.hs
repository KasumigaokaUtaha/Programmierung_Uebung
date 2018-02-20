
data Tree = Leaf Int | Node Tree Int Tree  deriving Show

testTree :: Tree
testTree = Node (Node (Leaf 1) 3 (Leaf 2)) 2 (Node (Leaf 6) 5 (Leaf 7))

testTree1 :: Tree
testTree1 = Node (Node (Leaf 1) 3 (Leaf 2)) 2 (Leaf 4)


pfadList :: Tree -> [[Int]]
pfadList (Leaf value) = [[value]]
pfadList (Node left value right) = (map (g value) pfadL) ++ (map (g value) pfadR)
                                    where pfadL = pfadList left
                                          pfadR = pfadList right
                                          g = \x y -> x : y

isGleich :: [Int] -> [Int] -> Bool
isGleich [] []  = True
isGleich _ []   = False
isGleich [] _   = False
isGleich (x : xs) ys | xs == [] = if (filter ((\x y -> x /= y) x) ys) == []
                                    then True else False
                     | xs /= [] = if (filter ((\x y -> x /= y) x) ys) == []
                                    then isGleich xs ys
                                        else False

isComplete :: Tree -> Bool
isComplete (Node left value right) = isGleich pfadLLength pfadRLength
                                    where pfadL = pfadList left
                                          pfadR = pfadList right
                                          pfadLLength = map length pfadL
                                          pfadRLength = map length pfadR

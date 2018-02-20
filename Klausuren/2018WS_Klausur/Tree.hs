
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

isComplete :: Tree -> Bool
isComplete tree = isEqual pfadLength
                    where pfad = pfadList tree
                          pfadLength = map length pfad

isEqual :: [Int] -> Bool
isEqual [] = True
isEqual (x : xs) = if (filter (\y -> y /= x) xs) == []
                        then True
                            else False

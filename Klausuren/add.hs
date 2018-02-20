addElements :: [Int] -> [Int] -> [Int]
addElements [] ys = ys
addElements xs [] = xs
addElements (x : xs) (y : ys) = (x + y) : addElements xs ys

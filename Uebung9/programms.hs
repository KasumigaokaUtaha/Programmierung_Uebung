isEven :: Int -> Bool
isEven x    | x == 0    = True
            | x > 0     = isOdd (x - 1)
            | x < 0     = isOdd (x + 1)

isOdd :: Int -> Bool
isOdd x     | x == 0    = False
            | x > 0     = isEven (x - 1)
            | x < 0     = isEven (x + 1)


arithSeries :: Int -> Int -> Int
arithSeries x d     | x < 0 || d <= 0       = 0
                    | x == 0                = 0
                    | x < d                 = x
                    | otherwise             = x + arithSeries (x - d) d


isSorted :: [Int] -> Bool
isSorted []             = True
isSorted [x]            = True
isSorted (x : y : zs)       = x < y && isSorted (y : zs)

interval :: Int -> Int -> [Int]
interval a b        | a > b     = []
                    | a == b    = [a]
                    | a < b     = [a] ++ interval (a + 1) b


selectKsmallest :: Int -> [Int] -> Int
selectKsmallest k xs     | k < 1 || length xs < k     = 0
                         | otherwise                  = selectKsmallestHilfe k (insertionsort xs)


selectKsmallestHilfe :: Int -> [Int] -> Int
selectKsmallestHilfe k (x : xs)     | k == 1             = x
                                    | otherwise         = selectKsmallestHilfe (k - 1) xs


insertionsort :: [Int] -> [Int]
insertionsort [] = []                -- when xs is [] , end of the recursion.
insertionsort (x : xs) = insert x (insertionsort xs)

insert :: Int -> [Int] -> [Int]
insert x [] = [x]         -- when ys is [] , end of the recursion.
insert x (y : ys)    | x < y          = x : y : ys
                     | otherwise      = y : insert x ys

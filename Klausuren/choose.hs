choose :: [a] -> Int -> [[a]]
choose     _    0 = [[]]
choose     []   _ = []
choose     (x : xs) 1 = [[x]] ++ choose xs 1
choose     (x : xs) n | n == 1 = [[x]] ++ choose xs 1
                      | n == len = [(x : xs)]
                      | n > len = [[]]
                      | n < 0 = [[]]
                      | otherwise = ((map ((\x y -> x ++ y) [x]) (choose xs (n-1)))
                                        ++ choose xs n)    
                       where len = length xs + 1

containsAll :: [a] -> [a] -> Bool
containsAll [] [] = True
containsAll  _ [] = False
containsAll [] _ = True
containsAll (x : xs) list = if condition then res else False
                            where condition = elem x list
                                  res = containsAll xs list

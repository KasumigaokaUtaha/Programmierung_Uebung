data Q = Z Int | Bruch Int Int  deriving Show

vereinfache :: Q -> Q
vereinfache (Z x) = Z x
vereinfache (Bruch x 0) = Bruch x 0
vereinfache (Bruch x y) | x == 0 = Z 0
                        | div y g == 1 = Z x
                        | div y g == -1 = Z (-x)
                        | otherwise = Bruch (div x g) (div y g)
                            where g = gcd x y

zahl1 :: Q
zahl1 = Bruch 2 0

zahl2 :: Q
zahl2 = Bruch 4 1

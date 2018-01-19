data MultTree a = Leaf a | Node a a [MultTree a]
                    deriving Show
t1 :: MultTree Int
t1 = Node 3 42 [
                Node 3 15 [
                    Leaf 3,
                    Leaf 11,
                    Leaf 12
                ],
                Node 19 42 [
                    Leaf 42,
                    Leaf 23
                ]
            ]


t2 :: MultTree Int
t2 = Node 3 42 [
            Node 3 15 [
                Leaf 3,
                Leaf 11,
                Leaf 12,
                Node 1 2 [
                    Leaf 3,
                    Leaf 2,
                    Leaf 4,
                    Leaf 4,
                    Leaf 10,
                    Leaf 9,
                    Leaf 3,
                    Leaf 11,
                    Leaf 12,
                    Node 1 2 [
                            Leaf 3,
                            Leaf 2,
                            Leaf 4,
                            Leaf 4,
                            Leaf 10,
                            Leaf 9
                    ]
                ]
            ],
            Node 19 42 [
                Leaf 42,
                Leaf 23
                ]
            ]


t3 :: [MultTree Int]
t3 = [Node 3 15 [Leaf 3, Leaf 11, Leaf 12], Node 19 42 [Leaf 42, Leaf 23]]

t4 :: MultTree Int
t4 = Node 3 15 [Leaf 3, Leaf 11, Leaf 12]

verzweigungsgrad :: MultTree a -> Int
verzweigungsgrad (Leaf _)      = 0
verzweigungsgrad (Node _ _ xs) = verzweigungsgradHilf xs

verzweigungsgradHilf :: [MultTree a] -> Int
verzweigungsgradHilf [] = 0
verzweigungsgradHilf xs = maximum(length(xs) : map verzweigungsgrad xs)

datenListe :: MultTree a -> [a]
datenListe (Leaf value)        = [value]
datenListe (Node _ _ (x : xs)) = (datenListe x) ++ (datenListeHilf xs)

datenListeHilf :: [MultTree a] -> [a]
datenListeHilf []       = []
datenListeHilf (x : xs) = (datenListe x) ++ (datenListeHilf xs)

datenIntervalle :: MultTree Int -> MultTree Int
datenIntervalle (Leaf x)      = Leaf x
datenIntervalle (Node x y trees) = multTreeMaxMin(Node x y (datenIntervalleHilf trees))

datenIntervalleHilf :: [MultTree Int] ->[MultTree Int]
datenIntervalleHilf ((Leaf value) : []) = [Leaf value]
datenIntervalleHilf ((Node x y trees): []) = [multTreeMaxMin(Node x y (datenIntervalleHilf trees))]
datenIntervalleHilf ((Leaf value) : multTrees) = (Leaf value) : (datenIntervalleHilf multTrees)
datenIntervalleHilf ((Node x y trees): multTrees) = multTreeMaxMin(Node x y (datenIntervalleHilf trees)) : (datenIntervalleHilf multTrees)

multTreeMaxMin :: MultTree Int -> MultTree Int
multTreeMaxMin (Node x y trees)     = Node a b trees
                                            where   a = minimum(getValue trees)
                                                    b = maximum(getValue trees)

getValue :: [MultTree Int] -> [Int]
getValue ((Leaf value) : [])      = [value]
getValue ((Node x y _) : [])      = [x, y]
getValue ((Leaf value) : trees)   = value : getValue(trees)
getValue ((Node x y _) : trees)   = [x, y] ++ getValue(trees)

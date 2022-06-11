import math
#volume of cube function is side * side * side
def cube(side):
    vol = side * side * side
    return vol
#volume of pyramid function is (1.0/3.0) * length * length * height
def pyr(length, height):
    volume = (1.0/3.0) * length * length * height
    return volume
#(volume of ellipsoid function is (4.0/3.0) * 3.14159 * radius_1 * radius_2* radius_3
def ell(radius_1, radius_2, radius_3):
    vol = (4.0/3.0) * math.pi * radius_1 * radius_2* radius_3
    return vol

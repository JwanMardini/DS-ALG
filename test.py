import matplotlib.pyplot as plt
import pandas as pd

data = {
    "Input": [1000, 5000, 10000, 50000, 100000, 500000, 1000000],
    "R_RANDOM_E": [
        0.1,
        0.6,
        1.8,
        34.4,
        152.2,
        6136.8,
        22584.1,
    ],
    "I_RANDOM_E": [
        0.6,
        1.6,
        3.6,
        68.0,
        317.8,
        7923.5,
        29416.8,
    ],
    "R_First_E": [
        0.3,
        0.5,
        0.9,
        17.6,
        77.9,
        1961.2,
        7077.2,
    ],
    "I_First_E": [
        0.8,
        1.5,
        1.7,
        18.1,
        75.5,
        2049,
        6866.5,
    ],
    "R_Median": [0.1, 0.5, 1.0, 27.2, 89.5, 2537.1, 5083.2],
    "I_Median": [0.4, 1.3, 1.5, 14.3, 59.8, 1604.3, 8518],
    "R_Insertion": [
        0.6,
        2.2,
        10.0,
        231.2,
        958,
        23544.0,
        90924,
    ],
    "I_Insertion": [
        2.6,
        22.2,
        114.9,
        2251.3,
        10330.1,
        239387,
        1964479.7,
    ],
}

df = pd.DataFrame(data)


plt.figure(figsize=(10, 6))

for column in df.columns[1:]:
    plt.plot(df["Input"], df[column], marker="o", label=column)

plt.xlabel("Input Size")
plt.ylabel("Execution Time (Miliscond)")
plt.title("Execution Time vs Input Size")
plt.xscale("linear")
plt.yscale("linear")
plt.legend()
plt.grid(True)
plt.show()

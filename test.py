import matplotlib.pyplot as plt;
import pandas as pd;


data = {
    "Input": [1000, 5000, 10000, 50000, 100000, 500000, 1000000],
    "R_First_E": [
        0.000077,
        0.000841,
        0.002872,
        0.053758,
        0.209241,
        5.156536,
        20.206356,
    ],
    "I_First_E": [
        0.000287,
        0.000904,
        0.003057,
        0.058382,
        0.213021,
        5.265896,
        20.336690,
    ],
    "R_RANDOM_E": [
        0.001504,
        0.008591,
        0.018586,
        0.136956,
        0.378545,
        6.016322,
        21.762732,
    ],
    "I_RANDOM_E": [
        0.001507,
        0.008604,
        0.018597,
        0.140148,
        0.387993,
        6.144049,
        22.405153,
    ],
    "R_Median": [0.000075, 0.000847, 0.002788, 0.056279, 0.212100, 5.208042, 20.209893],
    "I_Median": [0.000087, 0.000921, 0.003024, 0.059668, 0.224903, 5.238608, 20.632123],
    "R_Insertion": [
        0.000436,
        0.010724,
        0.045984,
        1.108961,
        4.403350,
        109.362253,
        435.039580,
    ],
    "I_Insertion": [
        0.000444,
        0.011690,
        0.060866,
        1.212144,
        5.791378,
        119.120725,
        573.083119,
    ],
}

df = pd.DataFrame(data)


plt.figure(figsize=(10, 6))

for column in df.columns[1:]:
    plt.plot(df["Input"], df[column], marker="o", label=column)

plt.xlabel("Input Size")
plt.ylabel("Execution Time (Seconds)")
plt.title("Execution Time vs Input Size")
plt.xscale("log")
plt.yscale("log")
plt.legend()
plt.grid(True)
plt.show()
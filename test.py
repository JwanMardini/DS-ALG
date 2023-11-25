import matplotlib.pyplot as plt
import pandas as pd

def nanoseconds_to_milliseconds(nanoseconds):
    milliseconds = nanoseconds / 1_000_000
    return milliseconds

data = {
    "Input": [1000, 5000, 10000, 50000, 100000, 300000, 500000, 700000, 1000000],
    "quickSortRandomPivot": [
        nanoseconds_to_milliseconds(1051030.0),
        nanoseconds_to_milliseconds(4842880.0),
        nanoseconds_to_milliseconds(5349300.0),
        nanoseconds_to_milliseconds(4.149317E7),
        nanoseconds_to_milliseconds(1.145113E8),
        nanoseconds_to_milliseconds(9.9261749E8),
        nanoseconds_to_milliseconds(2.50710363E9),
        nanoseconds_to_milliseconds(5.06324356E9),
        nanoseconds_to_milliseconds(9.61844766E9),
    ],
    "quickSortFirstElementPivot": [
        nanoseconds_to_milliseconds(189560.0),
        nanoseconds_to_milliseconds(4842880.0),
        nanoseconds_to_milliseconds(5349300.0),
        nanoseconds_to_milliseconds(4.149317E7),
        nanoseconds_to_milliseconds(1.145113E8),
        nanoseconds_to_milliseconds(9.9261749E8),
        nanoseconds_to_milliseconds(2.50710363E9),
        nanoseconds_to_milliseconds(5.06324356E9),
        nanoseconds_to_milliseconds(9.61844766E9),
    ],
    "I_Median": [
        nanoseconds_to_milliseconds(1051030.0),
        nanoseconds_to_milliseconds(4842880.0),
        nanoseconds_to_milliseconds(5349300.0),
        nanoseconds_to_milliseconds(4.149317E7),
        nanoseconds_to_milliseconds(1.145113E8),
        nanoseconds_to_milliseconds(9.9261749E8),
        nanoseconds_to_milliseconds(2.50710363E9),
        nanoseconds_to_milliseconds(5.06324356E9),
        nanoseconds_to_milliseconds(9.61844766E9),
    ],
    "R_Insertion": [
        nanoseconds_to_milliseconds(1051030.0),
        nanoseconds_to_milliseconds(4842880.0),
        nanoseconds_to_milliseconds(5349300.0),
        nanoseconds_to_milliseconds(4.149317E7),
        nanoseconds_to_milliseconds(1.145113E8),
        nanoseconds_to_milliseconds(9.9261749E8),
        nanoseconds_to_milliseconds(2.50710363E9),
        nanoseconds_to_milliseconds(5.06324356E9),
        nanoseconds_to_milliseconds(9.61844766E9),
    ],
    "I_Insertion": [
        nanoseconds_to_milliseconds(1051030.0),
        nanoseconds_to_milliseconds(7742880.0),
        nanoseconds_to_milliseconds(5889300.0),
        nanoseconds_to_milliseconds(4.167317E7),
        nanoseconds_to_milliseconds(1.145113E8),
        nanoseconds_to_milliseconds(9.9261749E8),
        nanoseconds_to_milliseconds(2.50710363E9),
        nanoseconds_to_milliseconds(5.06324356E9),
        nanoseconds_to_milliseconds(9.61844766E9),
    ],
}

df = pd.DataFrame(data)

plt.figure(figsize=(12, 8))

for column in df.columns[1:]:
    plt.plot(df["Input"], df[column], marker="o", label=column)

plt.xlabel("Input Size")
plt.ylabel("Execution Time (Milliseconds)")
plt.title("Execution Time vs Input Size")
plt.legend()
plt.grid(True)
plt.show()

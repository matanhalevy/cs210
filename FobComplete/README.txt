The code might be failing because:

1. The userMap in FobControlUnit may not have been created/initialized

2. When we look in the userMap for a given Key, the appropriate comparison (i.e., the right equals() is not being called)

The second hypothesis turns out to be the correct hypothesis. The fix is to generate equals() and hashCode() methods
on Fob that use the uniqueID as the means to compare two Fobs.
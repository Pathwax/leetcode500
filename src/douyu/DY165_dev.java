package douyu;

public class DY165_dev {
    public int compareVersion(String version1, String version2) {
        String[] splitV1 = version1.split("\\.");
        String[] splitV2 = version2.split("\\.");
        int start1 = 0, start2 = 0;
        while(start1 < splitV1.length && start2 < splitV2.length){
            int comparisonA = Integer.parseInt(splitV1[start1]);
            int comparisonB = Integer.parseInt(splitV2[start2]);
            if (comparisonA > comparisonB)
                return 1;
            else if (comparisonA < comparisonB)
                return - 1;
            else{
                start1++;
                start2++;
            }
        }
        while(start1 < splitV1.length){
            if (Integer.parseInt(splitV1[start1])==0){
                start1++;
            }else{
                return 1;
            }
        }
        while(start2 < splitV2.length){
            if (Integer.parseInt(splitV2[start2])==0){
                start2++;
            }else{
                return -1;
            }
        }
        return 0;
    }
}

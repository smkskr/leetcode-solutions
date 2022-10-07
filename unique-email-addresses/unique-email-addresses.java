class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> uniqueEmails = new HashSet<>();
        for(String email : emails){
            //split by @
            //split by +
            //replace "." with ""
            String[] splitByAtRate = email.split("@");
            String[] splitByPlus = splitByAtRate[0].split("\\+");
            StringBuilder localName = new StringBuilder();
            localName.append(splitByPlus[0].replace(".",""));
            localName.append("@");
            uniqueEmails.add(localName.append(splitByAtRate[1]).toString());
            
        }
        
        return uniqueEmails.size();
        
    }
}
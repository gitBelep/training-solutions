package lambdaoptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {
    List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> predicate){
        Member result = null;
        for (Member m : members){
            if (predicate.test(m)){
                result = m;
            }
        }
        return Optional.ofNullable(result);
    }

    public Optional<Double> averageNumberOfSkills(){
        Double average = null;
        double skillCounter = 0.0;
        for (Member m : members){
            skillCounter += m.getSkills().size();
        }
        if (!members.isEmpty()){
            average = skillCounter / members.size();
        }
        return Optional.ofNullable(average);
    }

}

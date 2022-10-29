package item18;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CustomHashSetByCompositionTest {

    @DisplayName("더할 때마다 카운트 증가 - 조합")
    @Test
    void addAll_Composition(){
        CustomHashSetByComposition<Integer> customHashSet = new CustomHashSetByComposition<>(new HashSet<>());

        List<Integer> numbers = Arrays.asList(1,2,3,4);

        customHashSet.addAll(numbers);
        customHashSet.add(5);

        assertThat(customHashSet.getAddCount()).isEqualTo(5);
    }

}
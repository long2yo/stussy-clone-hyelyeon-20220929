package com.stussy.stussyclonehyelyeon20220929.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({
        //왼쪽 부터 우선순위다! - 왼쪽에서 밑으로 내림
        ValidationGroups.NotBlankGroup.class,
        ValidationGroups.SizeCheckGroup.class,
        ValidationGroups.PatternCheckGroup.class,
        Default.class
})

public interface ValidationSequence {
}
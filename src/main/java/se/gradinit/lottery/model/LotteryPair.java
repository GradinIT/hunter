package se.gradinit.lottery.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import se.gradinit.blind.model.Blind;
import se.gradinit.hunter.model.Hunter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LotteryPair {
    Hunter hunter;
    Blind blind;
}

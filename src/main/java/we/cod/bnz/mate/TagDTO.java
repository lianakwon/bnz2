package we.cod.bnz.mate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagDTO {

  private boolean recruit; // 모집완료/모집중

  private String goal; // 스터디/프로젝트 : 목적

  private String space; // 온라인/오프라인 : 영역

  private Set<String> locas; // 모집지역 (locations)

  private Set<String> parts; // 모집분야

  private Set<String> langs; // 사용언어, 사용툴 (languages)

}

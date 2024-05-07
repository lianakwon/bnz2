package we.cod.bnz.member;

import lombok.Getter;

@Getter
public enum MemberRole {


  MANAGER("TEAM_MANAGER"),
  MEMBER("TEAM_MEMBER");

  private final String teamMemberRole;

  MemberRole(String teamMemberRole) {
    this.teamMemberRole = teamMemberRole;
  }

}

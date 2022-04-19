package models;
import lombok.*;
import lombok.experimental.SuperBuilder;

import static config.EnvConfig.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class User {

    private String  auth ;
    private String  achievements ;
    private String  backer ;
    private String  contributor ;
    private String  purchased ;
    private String  flags ;
    private String  history ;
    private String  items ;
    private String  invitations ;
    private String  party ;
    private String  preferences ;
    private String  profile ;
    private String  stats ;
    private String  inbox ;
    private String  tasksOrder ;
    private String  _v ;
    private String  balance ;
    private String  challenges ;
    private String  guilds ;
    private String  loginIncentives ;
    private String  invitesSent ;
    private String  pinnedItemsOrder ;
    private String  _id ;
    private String  apiToken ;
    private String  lastCron ;
    private String  newMessages ;
    private String  notifications ;
    private String  tags ;
    private String  extra ;
    private String  pushDevices ;
    private String  webhooks ;
    private String  pinnedItems ;
    private String  unpinnedItems ;
    private String  _ABTests ;
    private String  id ;
    private String  tasks;
}

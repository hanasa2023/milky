import * as types from '@saltify/milky-types';
import type z from 'zod';

export type ApiResponse =
  | {
      status: 'ok';
      retcode: 0;
      data: unknown;
    }
  | {
      status: 'failed';
      retcode: number;
      message: string;
    };

export type ApiCollection = {
  // System API
  get_login_info: () => types.GetLoginInfoOutput;
  get_impl_info: () => types.GetImplInfoOutput;
  get_user_profile: (input: z.input<typeof types.GetUserProfileInput>) => types.GetUserProfileOutput;
  get_friend_list: (input: z.input<typeof types.GetFriendListInput>) => types.GetFriendListOutput;
  get_friend_info: (input: z.input<typeof types.GetFriendInfoInput>) => types.GetFriendInfoOutput;
  get_group_list: (input: z.input<typeof types.GetGroupListInput>) => types.GetGroupListOutput;
  get_group_info: (input: z.input<typeof types.GetGroupInfoInput>) => types.GetGroupInfoOutput;
  get_group_member_list: (input: z.input<typeof types.GetGroupMemberListInput>) => types.GetGroupMemberListOutput;
  get_group_member_info: (input: z.input<typeof types.GetGroupMemberInfoInput>) => types.GetGroupMemberInfoOutput;
  get_cookies: (input: z.input<typeof types.GetCookiesInput>) => types.GetCookiesOutput;
  get_csrf_token: () => types.GetCSRFTokenOutput;

  // Message API
  send_private_message: (input: z.input<typeof types.SendPrivateMessageInput>) => types.SendPrivateMessageOutput;
  send_group_message: (input: z.input<typeof types.SendGroupMessageInput>) => types.SendGroupMessageOutput;
  get_message: (input: z.input<typeof types.GetMessageInput>) => types.GetMessageOutput;
  get_history_messages: (input: z.input<typeof types.GetHistoryMessagesInput>) => types.GetHistoryMessagesOutput;
  get_resource_temp_url: (input: z.input<typeof types.GetResourceTempUrlInput>) => types.GetResourceTempUrlOutput;
  get_forwarded_messages: (input: z.input<typeof types.GetForwardedMessagesInput>) => types.GetForwardedMessagesOutput;
  recall_private_message: (input: z.input<typeof types.RecallPrivateMessageInput>) => void;
  recall_group_message: (input: z.input<typeof types.RecallGroupMessageInput>) => void;
  mark_message_as_read: (input: z.input<typeof types.MarkMessageAsReadInput>) => void;

  // Friend API
  send_friend_nudge: (input: z.input<typeof types.SendFriendNudgeInput>) => void;
  send_profile_like: (input: z.input<typeof types.SendProfileLikeInput>) => void;
  get_friend_requests: (input: z.input<typeof types.GetFriendRequestsInput>) => types.GetFriendRequestsOutput;
  accept_friend_request: (input: z.input<typeof types.AcceptFriendRequestInput>) => void;
  reject_friend_request: (input: z.input<typeof types.RejectFriendRequestInput>) => void;

  // Group API
  set_group_name: (input: z.input<typeof types.SetGroupNameInput>) => void;
  set_group_avatar: (input: z.input<typeof types.SetGroupAvatarInput>) => void;
  set_group_member_card: (input: z.input<typeof types.SetGroupMemberCardInput>) => void;
  set_group_member_special_title: (input: z.input<typeof types.SetGroupMemberSpecialTitleInput>) => void;
  set_group_member_admin: (input: z.input<typeof types.SetGroupMemberAdminInput>) => void;
  set_group_member_mute: (input: z.input<typeof types.SetGroupMemberMuteInput>) => void;
  set_group_whole_mute: (input: z.input<typeof types.SetGroupWholeMuteInput>) => void;
  kick_group_member: (input: z.input<typeof types.KickGroupMemberInput>) => void;
  get_group_announcement_list: (input: z.input<typeof types.GetGroupAnnouncementListInput>) => types.GetGroupAnnouncementListOutput;
  send_group_announcement: (input: z.input<typeof types.SendGroupAnnouncementInput>) => void;
  delete_group_announcement: (input: z.input<typeof types.DeleteGroupAnnouncementInput>) => void;
  get_group_essence_messages: (input: z.input<typeof types.GetGroupEssenceMessagesInput>) => types.GetGroupEssenceMessagesOutput;
  set_group_essence_message: (input: z.input<typeof types.SetGroupEssenceMessageInput>) => void;
  quit_group: (input: z.input<typeof types.QuitGroupInput>) => void;
  send_group_message_reaction: (input: z.input<typeof types.SendGroupMessageReactionInput>) => void;
  send_group_nudge: (input: z.input<typeof types.SendGroupNudgeInput>) => void;
  get_group_notifications: (input: z.input<typeof types.GetGroupNotificationsInput>) => types.GetGroupNotificationsOutput;
  accept_group_request: (input: z.input<typeof types.AcceptGroupRequestInput>) => void;
  reject_group_request: (input: z.input<typeof types.RejectGroupRequestInput>) => void;
  accept_group_invitation: (input: z.input<typeof types.AcceptGroupInvitationInput>) => void;
  reject_group_invitation: (input: z.input<typeof types.RejectGroupInvitationInput>) => void;

  // File API
  upload_private_file: (input: z.input<typeof types.UploadPrivateFileInput>) => types.UploadPrivateFileOutput;
  upload_group_file: (input: z.input<typeof types.UploadGroupFileInput>) => types.UploadGroupFileOutput;
  get_private_file_download_url: (input: z.input<typeof types.GetPrivateFileDownloadUrlInput>) => types.GetPrivateFileDownloadUrlOutput;
  get_group_file_download_url: (input: z.input<typeof types.GetGroupFileDownloadUrlInput>) => types.GetGroupFileDownloadUrlOutput;
  get_group_files: (input: z.input<typeof types.GetGroupFilesInput>) => types.GetGroupFilesOutput;
  move_group_file: (input: z.input<typeof types.MoveGroupFileInput>) => void;
  rename_group_file: (input: z.input<typeof types.RenameGroupFileInput>) => void;
  delete_group_file: (input: z.input<typeof types.DeleteGroupFileInput>) => void;
  create_group_folder: (input: z.input<typeof types.CreateGroupFolderInput>) => types.CreateGroupFolderOutput;
  rename_group_folder: (input: z.input<typeof types.RenameGroupFolderInput>) => void;
  delete_group_folder: (input: z.input<typeof types.DeleteGroupFolderInput>) => void;
}

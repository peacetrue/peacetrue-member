import React from "react";
import {Resource} from "react-admin";

import {MemberList} from './list';
import {MemberCreate} from './create';
import {MemberEdit} from './edit';
import {MemberShow} from './show';

export const Member = {list: MemberList, create: MemberCreate, edit: MemberEdit, show: MemberShow};
const MemberResource = <Resource options={{label: '会员'}} name="users" {...Member} />;
export default MemberResource;

import React from 'react';
import {DateField, Show, SimpleShowLayout, TextField} from 'react-admin';

export const MemberShow = (props) => {
    console.info('MemberShow:', props);
    return (
        <Show {...props} title={`${props.options.label}#${props.id}`}>
            <SimpleShowLayout>
                <TextField label={'会员名'} source="username"/>
                <TextField label={'密码'} source="password"/>
                <TextField label={'创建者主键'} source="creatorId"/>
                <DateField label={'创建时间'} source="createdTime" showTime/>
                <TextField label={'修改者主键'} source="modifierId"/>
                <DateField label={'最近修改时间'} source="modifiedTime" showTime/>
            </SimpleShowLayout>
        </Show>
    );
};

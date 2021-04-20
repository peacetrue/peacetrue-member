import React from 'react';
import {Datagrid, DateField, DateInput, EditButton, Filter, List, TextField, TextInput} from 'react-admin';

const Filters = (props) => (
    <Filter {...props}>
        <TextInput label={'会员名'} source="username" allowEmpty alwaysOn/>
        <DateInput label={'创建时间起始值'} source="createdTime.lowerBound" allowEmpty alwaysOn/>
        <DateInput label={'创建时间结束值'} source="createdTime.upperBound" allowEmpty alwaysOn/>
        <DateInput label={'最近修改时间起始值'} source="modifiedTime.lowerBound" allowEmpty/>
        <DateInput label={'最近修改时间结束值'} source="modifiedTime.upperBound" allowEmpty/>
    </Filter>
);

export const MemberList = props => {
    console.info('MemberList:', props);
    return (
        <List {...props} title={`${props.options.label}列表`} filters={<Filters/>}
              sort={{field: 'createdTime', order: 'desc'}}>
            <Datagrid rowClick="show">
                <TextField label={'会员名'} source="username"/>
                <TextField label={'密码'} source="password"/>
                <TextField label={'创建者主键'} source="creatorId"/>
                <DateField label={'创建时间'} source="createdTime" showTime/>
                <TextField label={'修改者主键'} source="modifierId"/>
                <DateField label={'最近修改时间'} source="modifiedTime" showTime/>
                <EditButton/>
            </Datagrid>
        </List>
    )
};

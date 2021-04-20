import React from 'react';
import {Edit, maxLength, minLength, PasswordInput, regex, required, SimpleForm, TextInput} from 'react-admin';

export const MemberEdit = (props) => {
    console.info('MemberEdit:', props);
    let validate = [required(), minLength(6), maxLength(32), regex(/^[0-9a-zA-Z-.]+$/)];
    return (
        <Edit {...props} title={`${props.options.label}#${props.id}`}>
            <SimpleForm>
                <TextInput label={'会员名'} source="username" validate={validate}/>
                <PasswordInput label={'密码'} source="password" validate={validate}/>
            </SimpleForm>
        </Edit>
    );
};

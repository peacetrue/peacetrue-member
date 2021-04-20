import React from 'react';
import {Create, maxLength, minLength, PasswordInput, regex, required, SimpleForm, TextInput,} from 'react-admin';

export const MemberCreate = (props) => {
    console.info('MemberCreate:', props);
    let validate = [required(), minLength(6), maxLength(32), regex(/^[0-9a-zA-Z-.]+$/)];
    return (
        <Create {...props} title={`新建${props.options.label}`}>
            <SimpleForm>
                <TextInput label={'会员名'} source="username" validate={validate}/>
                <PasswordInput label={'密码'} source="password" validate={validate}/>
            </SimpleForm>
        </Create>
    );
};

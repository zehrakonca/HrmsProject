import React from 'react'
import { Grid, Segment,Form,Button, Image, Divider } from 'semantic-ui-react'
import loginPhoto from '../../img/meeting.jpg';

export default function Login() {
    return (
        <div>
            <Segment>
                <Grid columns='equal'>
                    <Grid.Row textAlign="center">
                        <Grid.Column>
                            <Segment color='teal'>
                                <Form>
                                    <Form.Input
                                        icon='user'
                                        iconPosition='left'
                                        label='Email'
                                        placeholder='Please enter your email.'
                                    />
                                    <Form.Input
                                        icon='lock'
                                        iconPosition='left'
                                        label='Password'
                                        type='Please enter your password.'
                                    />
                                    <Button content='Login' color="teal" />
                                </Form>
                                <Divider horizontal>OR</Divider>
                                Sign UP!
                            </Segment>
                        </Grid.Column>
                        <Grid.Column>
                            <Segment color='teal'>
                                <Image src={loginPhoto}/>
                            </Segment>
                        </Grid.Column>
                    </Grid.Row>
                </Grid>
            </Segment>
        </div>
    )
}

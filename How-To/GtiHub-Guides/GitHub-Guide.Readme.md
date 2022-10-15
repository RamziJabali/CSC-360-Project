# GitHub Guides
## How to make a github branch 
### get out your current directory 
`cd ..`
### switch to our project
`cd CSC-360-Project/`   
### Make branch that is tracked by jira
1. Click on issue
2. Click on Create Branch(Click copy) == `git checkout -b DT-8-use-case-diagram-opa-page`
3. Paste it into terminal
4. Press enter
5. YAY! branch is created

### Will now track current changes on this branch
1. type and enter `git status` to check the changes, you will see red colored files. Those are the new additions which are not added.
2. type and enter `git add *` to add all changes, or `git add /file_you_wanna_add`
3. type and enter `git status` you will now see green files. Those are now added.
4. type and enter `git commit -m "enter your message here"` this will now make a commit of all your added files. Include a thoughtful message of what this commit is 
5. type and enter `git push origin HEAD` to push this branch to GitHub for all users to see.
6. YAY! You pushed a commit to your branch

### What to do when branch is finished
1. type and enter `git checkout main` to switch branchs to the main branch.
2. type and enter `git pull` to pull all updated code from the main branch.
3. YAY! you now pulled all updated code to your desktop, you are now up to date with everyone!


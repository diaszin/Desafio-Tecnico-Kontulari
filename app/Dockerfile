FROM node:20.9

WORKDIR /app

COPY package.json ./
RUN yarn install

COPY . .

CMD yarn dev
"use client"

import { useState } from "react";
import SearchProfile from "./components/SearchProfile";
import ProfileBanner from "./components/ProfileBanner";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import ProfileRepositories from "./components/ProfileRepositories";

export default function Home() {
  const [githubUsername, setGithubUsername] = useState<string | null>(null)
  const queryClient = new QueryClient()



  return <QueryClientProvider client={queryClient}>
    <main className="w-full h-full flex items-center justify-center flex-col gap-5">
      <h1 className="font-inter font-normal text-[3.75rem] max-lg:text-[7vw]">
        <span className="text-kontulari-color">Kontulari</span> GithubSearch
      </h1>
      <SearchProfile onSearch={(text) =>{
        setGithubUsername(text)
      }} />
      {githubUsername && <ProfileBanner username={githubUsername}/>}
      {githubUsername && <ProfileRepositories username={githubUsername}/>}
    </main>
  </QueryClientProvider>
}
